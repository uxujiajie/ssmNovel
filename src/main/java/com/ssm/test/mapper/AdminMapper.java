package com.ssm.test.mapper;

import com.ssm.test.domain.Admin;
import org.springframework.stereotype.Repository;

/**
 * Created by xu on 2017/8/10.
 */
@Repository
public interface AdminMapper {

    Admin selectAdminUser(Admin admin);

}
