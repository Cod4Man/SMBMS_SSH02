/*
package cn.smbms.filter;

import cn.smbms.dao.BaseDao;
import cn.smbms.service.user.UserService;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(urlPatterns = "/*")
public class CharacterEncoding  implements Filter {
    ServletContext context = null;
    ApplicationContext ac = null;
    TransactionStatus ts = null;
    @Override
    public void init(FilterConfig config) throws ServletException {
         context = config.getServletContext();
         ac = WebApplicationContextUtils.getWebApplicationContext(context);
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
        HibernateTransactionManager txx = (HibernateTransactionManager) ac.getBean("transactionManager");
		Transaction tx = (Transaction) txx;
		try {
			// TODO Auto-generated method stub
			System.out.println("事务操作Filter");
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			chain.doFilter(request, response);
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		}

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
*/
