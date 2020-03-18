package trace.dubbo.provider.service;

import trace.dubbo.core.model.Comment;
import trace.dubbo.core.model.Product;
import trace.dubbo.core.service.CommentService;
import trace.dubbo.core.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* 产品服务实现
* 作者：姜敏
* 版本：V1.0
* 创建日期：2017/4/13
* 修改日期:2017/4/13
*/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private CommentService commentService;

    @Override
    public Product getByid(Long id) {
        Product product=new Product();
        product.setId(id);
        product.setName(id.toString());
        List<Comment> comments=this.commentService.getCommentsByProductId(id);
        product.setComments(comments);
        return product;
    }
}
