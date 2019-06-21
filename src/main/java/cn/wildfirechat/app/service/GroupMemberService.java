package cn.wildfirechat.app.service;

import cn.wildfirechat.app.entity.GroupMember;
import cn.wildfirechat.app.mapper.GroupMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupMemberService {


    @Autowired
    GroupMemberMapper groupMemberMapper;

    public List<GroupMember> getGroupIds(String _mid) {
        return groupMemberMapper.getGroupIds(_mid);
    }
}
