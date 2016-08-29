package com.JunChang.SpringCalendar.Dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.JunChang.SpringCalendar.bean.UserBean;
 
 
@Repository
public class UserDao {
    
    @Autowired
    SqlSession sqlSession;
    
    public UserBean selectUserByUsername(String username){
        return sqlSession.selectOne("selectUserByUsername", username);
    }
    
    public int insertUserMinimum(UserBean ub){
        return sqlSession.insert("insertUser", ub);
    }
}
