package leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 题目关联关系工具
 *  用于记录题目关联关系以及查看未记录的(已被关联的)题目之用
 * @author: wyj
 * @date: 2021/04/19
 */
public class RelationUtil {
    private static Map<String, Node> data=null;
    public static void main(String[] args) {
        //执行关联题目
        runQuestionBind();
    }

    /**
     * 获取未录入的关联题目
     */
    private static void getUnrecordRelationList() {
        List<Node> questions=new ArrayList<>();
        //扫描题目
        recursiveFiles("src/leetcode",questions);
        Map<String,Node> tmp=new HashMap<>();
        for (Node question : questions) {
            tmp.put(question.getNumber(),question);
        }
        data = getData();
        List<Integer> relations=new ArrayList<>();
        for (Node value : data.values()) {
            List<Integer> relationList = value.getRelationList();
            for (Integer s : relationList) {
                if(!relations.contains(s)){
                    relations.add(s);
                }
            }
        }
        Set<Integer> unrecord=new TreeSet<>();
        for (Integer relation : relations) {
            Node node = data.get(Integer.toString(relation));
            if(node==null){
                unrecord.add(relation);
            }
        }
        System.out.println("未录入的题目有:"+unrecord);
    }

    /**
     * 获取未录入的题目，最大值为题目最大值
     */
    private static void getUnrecordList() {
        List<Node> questions=new ArrayList<>();
        //扫描题目
        recursiveFiles("src/leetcode",questions);
        List<Integer> nowList=new ArrayList<>();
        int max=0;
        for (Node n : questions) {
            String number = n.getNumber();
            int i = Integer.parseInt(number);
            max=Math.max(max, i);
            nowList.add(i);
        }
        List<Integer> unrecordList=new ArrayList<>();
        for (int i=1;i<max;i++){
            if(!nowList.contains(i)){
                unrecordList.add(i);
            }
        }
        System.out.println("未录入的题目有:"+unrecordList);
    }

    /**
     * 进行题目关联
     */
    private static void runQuestionBind() {
        while (true){
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("退出输入:q");
                System.out.println("输入b进行题目关联，输入d查看录入的已关联题目，a查看当前顺序中未记录的题目");
                String sc = scanner.next();
                if("b".equals(sc)){
                    detect();
                    System.out.println("输入需要添加关联题目的题目号:");
                    String next = scanner.next();
                    if("q".equals(next)){
                        return;
                    }
                    int i = Integer.parseInt(next);
                    Node node = data.get(next);
                    System.out.println("当前题目位置:"+next);
                    String relationList=null;
                    if(node==null){
                        System.out.println("请开始关联题目添加,添加示例:1,2,3");
                        relationList = scanner.next();
                    }else{
                        System.out.println("当前已关联题目:"+node.getRelationList());
                        System.out.println("请开始关联题目添加,添加示例:1,2,3");
                        relationList = scanner.next();
                    }
                    if("q".equals(relationList)){
                        return;
                    }
                    relationList = relationList.replaceAll("，", ",");
                    String[] split = relationList.split(",");
                    List<Integer> rlist=new ArrayList<>();
                    for (String s : split) {
                        if(s!=null&&s.trim().length()>0){
                            rlist.add(Integer.parseInt(s));
                        }
                    }
                    System.out.println("确定为题目:"+next+",添加关联题:"+relationList);
                    System.out.println("请输入：y or n");
                    String next1 = scanner.next();
                    if("q".equals(next1)){
                        return;
                    }
                    if("y".equals(next1)){
                        Node node2 = data.get(next);
                        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
                        String format = sdf.format(new Date());
                        node2.setDate(format);
                        Collections.sort(rlist);
                        node2.setRelationList(rlist);
                        writeData();
                    }
                }else if("d".equals(sc)){
                    getUnrecordRelationList();
                }else if("a".equals(sc)){
                    getUnrecordList();
                }else{
                    System.out.println("输入错误");
                }
            }catch (Exception e) {
                System.out.println("输入错误请重新输入");
//                e.printStackTrace();
            }
        }
    }

    private static void writeData() {
        try(BufferedWriter bw=new BufferedWriter(new FileWriter("src/leetcode/relation.txt"))){
            bw.write(JSON.toJSONString(data));
            bw.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void detect(){
        List<Node> questions=new ArrayList<>();
        //扫描题目
        recursiveFiles("src/leetcode",questions);
        //获取存储数据
        data = getData();
        //未被记录或关联题未被记录的题目
        List<String> unrecord=new ArrayList<>();
        //判断是否被记录
        for (Node question : questions) {
            String number = question.getNumber();
            Node node = data.get(number);
            if(node == null){
                unrecord.add(number);
                data.put(number,question);
            }else{
                if(node.getRelationList().size()==0){
                    unrecord.add(number);
                }
            }
        }
        System.out.println("未被记录或关联题未被记录的题目为："+unrecord);
    }

    private static Map<String,Node> getData() {
        try(BufferedReader br=new BufferedReader(new FileReader("src/leetcode/relation.txt"))){
            String s=null;
            StringBuilder data=new StringBuilder();
            while ((s=br.readLine())!=null){
                data.append(s);
            }
            Map<String, Node> obj = JSON.parseObject(data.toString(), new TypeReference<HashMap<String, Node>>() {
            });
            return obj;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 扫描文件，获取到具体的文件(非文件夹)
     * @param path
     */
    private static void recursiveFiles(String path,List<Node> questions){
        File file=new File(path);
        File[] files=file.listFiles();
        if(files.length==0){
            System.out.println("该文件目录为空");
        }else{
            for(File f:files){
                if(f.isDirectory()){
                    //测试此抽象路径名表示的文件是否是一个目录。
                    recursiveFiles(f.getAbsolutePath(),questions);
                }else{
                    String name = f.getName();
                    if("A".equals(name.substring(0,1))&&name.indexOf(".java")!=-1){
                        Node node = new Node();
                        String number = name.substring(1, name.indexOf("_"));
                        String qName = name.substring(name.indexOf("_")+1, name.lastIndexOf("."));
                        node.setName(qName);
                        node.setNumber(number);
                        questions.add(node);
                    }
                }
            }
        }
    }
}

class Node{
    String number;
    String name;
    String date;
    List<Integer> relationList=new ArrayList<>();

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getRelationList() {
        return relationList;
    }

    public void setRelationList(List<Integer> relationList) {
        this.relationList = relationList;
    }

    @Override
    public String toString() {
        return "Node{" +
                "number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", relationList=" + relationList +
                '}';
    }
}
