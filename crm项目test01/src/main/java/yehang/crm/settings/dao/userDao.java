package yehang.crm.settings.dao;

import org.apache.ibatis.annotations.Param;
import yehang.crm.settings.domain.user;

public interface userDao {
    user login(@Param("name") String name, @Param("password") String password);

}
