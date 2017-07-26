package manager;

import po.MailPo;

import java.util.List;

public interface SkillMailManager {
    /**
     * 按memberId 查相关的mail任务
     * @return
     */
    List<MailPo> querySkillMailsByMemberId(Long memberId);

    /**
     * 增加mail(附加定时任务)
     * @param mailPo
     */
    void insertSkillMail(MailPo mailPo);

    /**
     * 按id 删 mail(删定时任务)
     * @param mailId
     */
    void deleteSkillMailBy(Long mailId);

    /**
     * 更改状态
     * @param mailId
     * @param state -2:跳过 -1:失败 0:进行中 1:成功
     */
    void updateSkillMailState(Long mailId ,Integer state);
}
