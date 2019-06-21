package cn.wildfirechat.app.mapper;

import cn.wildfirechat.app.entity.GroupMember;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Resource

public interface GroupMemberMapper {
    List<GroupMember> getGroupIds(String _mid);
}
