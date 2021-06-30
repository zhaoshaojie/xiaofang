package freemarker.sysroley.service.impl;

import freemarker.sysroley.entity.TUserInfo;
import freemarker.sysroley.mapper.TUserInfoMapper;
import freemarker.sysroley.service.TUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息表 服务实现类
 * </p>
 *
 * @author sjzhao
 * @since 2021-06-30
 */
@Service
public class TUserInfoServiceImpl extends ServiceImpl<TUserInfoMapper, TUserInfo> implements TUserInfoService {

}
