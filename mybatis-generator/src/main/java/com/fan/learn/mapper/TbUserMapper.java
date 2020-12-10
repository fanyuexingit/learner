package com.fan.learn.mapper;

import com.fan.learn.model.TbUser;
import java.util.List;

public interface TbUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Thu Dec 10 10:43:45 CST 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Thu Dec 10 10:43:45 CST 2020
     */
    int insert(TbUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Thu Dec 10 10:43:45 CST 2020
     */
    TbUser selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Thu Dec 10 10:43:45 CST 2020
     */
    List<TbUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_user
     *
     * @mbg.generated Thu Dec 10 10:43:45 CST 2020
     */
    int updateByPrimaryKey(TbUser record);
}