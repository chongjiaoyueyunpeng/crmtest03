package yehang.crm.web.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import yehang.crm.settings.domain.user;
import yehang.crm.utils.*;
import yehang.crm.settings.dao.*;
public class loginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String passwd = request.getParameter("passwd");
        passwd=MD5Util.getMD5(passwd);
        InputStream resourceAsStream = Resources.getResourceAsStream("mybatis.xml");
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder=new SqlSessionFactoryBuilder();
        SqlSessionFactory build = sqlSessionFactoryBuilder.build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        userDao dao = sqlSession.getMapper(userDao.class);
        user login = dao.login(username, passwd);
        if(login!=null){
            response.getWriter().print(true);
        }else {
            response.getWriter().print(false);
        }


    }



}
