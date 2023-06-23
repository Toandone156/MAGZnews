
import com.toandone.magznews.dao.impl.AccountDAO;
import com.toandone.magznews.dao.impl.CommentDAO;
import com.toandone.magznews.dao.impl.NewsDAO;
import com.toandone.magznews.dao.impl.RoleDAO;
import com.toandone.magznews.model.AccountModel;
import com.toandone.magznews.model.CommentModel;
import com.toandone.magznews.model.RoleModel;
import java.sql.Date;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author LENOVO
 */
public class test {

    public static void main(String[] args) {
        
        new NewsDAO().updateView(2, 53L);
    }
}
