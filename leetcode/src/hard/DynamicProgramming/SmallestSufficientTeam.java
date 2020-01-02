package hard.DynamicProgramming;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * 作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表）。
 *
 * 所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。
 *
 * 我们可以用每个人的编号来表示团队中的成员：例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。
 *
 * 请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按任意顺序返回答案，本题保证答案存在。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
 * 输出：[0,2]
 * 示例 2：
 *
 * 输入：req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 * 输出：[1,2]
 *
 */
public class SmallestSufficientTeam {
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<Integer> result = new ArrayList<Integer>();
        List<Integer> record = new ArrayList<Integer>();
        dp(req_skills, people, record, result,0);

        int[] res = new int[record.size()];
        for(int i=0; i< record.size();i++){
            res[i] = record.get(i);
        }
        return res;
   }

   void dp(String[] req_skills, List<List<String>> people, List<Integer> record, List<Integer> result, int index){
        System.out.println("index:" + index);
        if(index > people.size()){
            return;
        }
        if(exist(result, people, req_skills )){
            if(record.isEmpty()){
                record.clear();
                for(Integer item: result){
                    record.add(item);
                }
            } else {
                if(cal(result)<cal(record)){
                    record.clear();
                    for(Integer item: result){
                        record.add(item);
                    }
                }
            }
        }
        result.add(index);
        dp(req_skills, people, record, result,index+1);
        result.remove(Integer.valueOf(index));
        dp(req_skills, people, record, result,index+1);
        return;
   }

   boolean exist(List<Integer> record , List<List<String>> people, String[] req_skills){
        List<String> temp = new ArrayList<String>();
        for(Integer index: record){
            temp.addAll(people.get(index.intValue()));
        }
        temp = new ArrayList<>(new LinkedHashSet<>(temp));
        List<String> req = new ArrayList<>();
        for(int i=0;i<req_skills.length;i++){
            req.add(req_skills[i]);
        }
        return temp.retainAll(req);
   }

   int cal(List<Integer> record){
        return record.size();
   }
}







