package cn.wildfirechat.app.api;

import cn.wildfirechat.app.entity.GroupMember;
import cn.wildfirechat.app.pojo.RequestModel;
import cn.wildfirechat.app.pojo.ResponeResultModel;
import cn.wildfirechat.app.service.GroupMemberService;
import cn.wildfirechat.app.utils.FastJsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
public class GroupMemberController {

    @Autowired
    private GroupMemberService groupMemberService;

    @RequestMapping(value = "getGroupIds")
    @ResponseBody
    public String GetUser(@RequestBody String requestData) {
        ResponeResultModel result = new ResponeResultModel();
        RequestModel requestModel = FastJsonUtils.toBean(requestData, RequestModel.class);
        if (requestModel == null) {
            result.setMessage("参数格式无效");
            result.setResultCode(-2);
            return FastJsonUtils.toJSONString(result);
        }
//        Map<String, String> map = FastJsonUtils.toBean(requestModel.getData(), Map.class);
//        String mid = map.get("userId");
//        if (mid == null || mid.equals("")) {
//            result.setMessage("参数错误");
//            result.setResultCode(-2);
//            return FastJsonUtils.toJSONString(result);
//        }
        System.out.println(requestModel.getUserId());
        List<GroupMember> groupIds = groupMemberService.getGroupIds(requestModel.getUserId());
        System.out.println("groupIds.size" + groupIds.size());
        result.setResultCode(0);
        result.setData(FastJsonUtils.toJSONString(groupIds));
        return FastJsonUtils.toJSONString(result);
    }

    @RequestMapping(value = "test")
    @ResponseBody
    public String getMember(@RequestBody String data) {
        return "123";
    }
}
