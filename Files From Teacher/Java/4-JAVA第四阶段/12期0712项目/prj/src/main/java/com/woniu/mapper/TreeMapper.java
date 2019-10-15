package com.woniu.mapper;

import com.woniu.model.Tree;
import com.woniu.model.TreeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TreeMapper {
	List findTreeWithUid(Integer uid);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    int countByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    int deleteByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    int insert(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    int insertSelective(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    List<Tree> selectByExample(TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    Tree selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    int updateByExampleSelective(@Param("record") Tree record, @Param("example") TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    int updateByExample(@Param("record") Tree record, @Param("example") TreeExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    int updateByPrimaryKeySelective(Tree record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tree
     *
     * @mbggenerated Mon Jul 08 10:17:45 CST 2019
     */
    int updateByPrimaryKey(Tree record);
}