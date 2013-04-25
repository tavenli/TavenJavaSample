package com.taven.app.hibernate;

import java.util.List;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.taven.app.hibernate.dao.UserInfoDao;
import com.taven.app.hibernate.vo.FriendVO;
import com.taven.app.hibernate.vo.OrderVO;
import com.taven.app.hibernate.vo.UserInfoVO;

/**
 * <pre>
 * 使用注解方式的JPA 数据库操作
 * </pre>
 * 
 * @author Taven.Li <br>
 *         <p>
 *         CreateTime 2012-5-16
 *         </p>
 */
@Service
public class HibernateDemo2 {

	private static Log log = LogFactory.getLog(HibernateDemo2.class);

	@Autowired
	private UserInfoDao userInfoDao;

	public void addUserInfo() {

		UserInfoVO userInfoVO = new UserInfoVO();

		userInfoVO.setUserName("Taven.Li");
		userInfoVO.setUserAge(30);

		userInfoDao.saveJobLog(userInfoVO);

	}

	@Transactional
	public void showUserInfo() {
		//事物要被外部类调用才会生效，被自己调用不会生效

		List<UserInfoVO> list = userInfoDao.getAllUserInfo();
		for (UserInfoVO vo : list) {
			Set<OrderVO> orderVOs = vo.getOrderVOs();
			log.info("订单数：" + orderVOs.size());
			for (OrderVO orderVO : orderVOs) {
				log.info("ProductName：" + orderVO.getProductName());
			}

			Set<FriendVO> friendVOs = vo.getFriendVOs();
			log.info("朋友数：" + friendVOs.size());
			for (FriendVO friendVO : friendVOs) {
				log.info("FriendName：" + friendVO.getFriendName());

			}
		}

		log.info("当前共有数据：" + list.size());

	}

}
