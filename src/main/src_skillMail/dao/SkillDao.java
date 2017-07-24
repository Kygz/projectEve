package dao;

import po.MailPo;

import java.util.List;

public interface SkillDao {
    /**
     * 按state查相关的mail任务
     * @param state -2:跳过 -1:失败 0:进行中 1:成功
     * @return
     */
    List<MailPo> queryAllSkillMailsByDone(Integer state);
    /**
     * 按memberId 查相关的mail任务
     * @param memberId
     * @return
     */
    List<MailPo> querySkillMailsByMemberId(Long memberId);

    /**
     * 按mailId 查相关的mail任务
     * @param mailId
     * @return
     */
    MailPo querySkillMailByMailId(Long mailId);

    /**
     * 按id 删 mail
     * @param mailId
     */
    void deleteSkillMailBy(Long mailId);

    /**
     * 更改状态
     * @param mailPo
     */
    void updateSkillMailState(MailPo mailPo);

    /**
     * 加实体
     * @param mailPo
     */
    void insertSkillMail(MailPo mailPo);
}
