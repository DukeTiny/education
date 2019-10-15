package com.cxz.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public OrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOrderidIsNull() {
            addCriterion("orderId is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderId is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(String value) {
            addCriterion("orderId =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(String value) {
            addCriterion("orderId <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(String value) {
            addCriterion("orderId >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(String value) {
            addCriterion("orderId >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(String value) {
            addCriterion("orderId <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(String value) {
            addCriterion("orderId <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLike(String value) {
            addCriterion("orderId like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotLike(String value) {
            addCriterion("orderId not like", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<String> values) {
            addCriterion("orderId in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<String> values) {
            addCriterion("orderId not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(String value1, String value2) {
            addCriterion("orderId between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(String value1, String value2) {
            addCriterion("orderId not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNull() {
            addCriterion("storeId is null");
            return (Criteria) this;
        }

        public Criteria andStoreidIsNotNull() {
            addCriterion("storeId is not null");
            return (Criteria) this;
        }

        public Criteria andStoreidEqualTo(String value) {
            addCriterion("storeId =", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotEqualTo(String value) {
            addCriterion("storeId <>", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThan(String value) {
            addCriterion("storeId >", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidGreaterThanOrEqualTo(String value) {
            addCriterion("storeId >=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThan(String value) {
            addCriterion("storeId <", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLessThanOrEqualTo(String value) {
            addCriterion("storeId <=", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidLike(String value) {
            addCriterion("storeId like", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotLike(String value) {
            addCriterion("storeId not like", value, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidIn(List<String> values) {
            addCriterion("storeId in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotIn(List<String> values) {
            addCriterion("storeId not in", values, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidBetween(String value1, String value2) {
            addCriterion("storeId between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andStoreidNotBetween(String value1, String value2) {
            addCriterion("storeId not between", value1, value2, "storeid");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createTime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNull() {
            addCriterion("payTime is null");
            return (Criteria) this;
        }

        public Criteria andPaytimeIsNotNull() {
            addCriterion("payTime is not null");
            return (Criteria) this;
        }

        public Criteria andPaytimeEqualTo(Date value) {
            addCriterion("payTime =", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotEqualTo(Date value) {
            addCriterion("payTime <>", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThan(Date value) {
            addCriterion("payTime >", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("payTime >=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThan(Date value) {
            addCriterion("payTime <", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeLessThanOrEqualTo(Date value) {
            addCriterion("payTime <=", value, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeIn(List<Date> values) {
            addCriterion("payTime in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotIn(List<Date> values) {
            addCriterion("payTime not in", values, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeBetween(Date value1, Date value2) {
            addCriterion("payTime between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andPaytimeNotBetween(Date value1, Date value2) {
            addCriterion("payTime not between", value1, value2, "paytime");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeIsNull() {
            addCriterion("deliveryTime is null");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeIsNotNull() {
            addCriterion("deliveryTime is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeEqualTo(Date value) {
            addCriterion("deliveryTime =", value, "deliverytime");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeNotEqualTo(Date value) {
            addCriterion("deliveryTime <>", value, "deliverytime");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeGreaterThan(Date value) {
            addCriterion("deliveryTime >", value, "deliverytime");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeGreaterThanOrEqualTo(Date value) {
            addCriterion("deliveryTime >=", value, "deliverytime");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeLessThan(Date value) {
            addCriterion("deliveryTime <", value, "deliverytime");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeLessThanOrEqualTo(Date value) {
            addCriterion("deliveryTime <=", value, "deliverytime");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeIn(List<Date> values) {
            addCriterion("deliveryTime in", values, "deliverytime");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeNotIn(List<Date> values) {
            addCriterion("deliveryTime not in", values, "deliverytime");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeBetween(Date value1, Date value2) {
            addCriterion("deliveryTime between", value1, value2, "deliverytime");
            return (Criteria) this;
        }

        public Criteria andDeliverytimeNotBetween(Date value1, Date value2) {
            addCriterion("deliveryTime not between", value1, value2, "deliverytime");
            return (Criteria) this;
        }

        public Criteria andRecievetimeIsNull() {
            addCriterion("RecieveTime is null");
            return (Criteria) this;
        }

        public Criteria andRecievetimeIsNotNull() {
            addCriterion("RecieveTime is not null");
            return (Criteria) this;
        }

        public Criteria andRecievetimeEqualTo(Date value) {
            addCriterion("RecieveTime =", value, "recievetime");
            return (Criteria) this;
        }

        public Criteria andRecievetimeNotEqualTo(Date value) {
            addCriterion("RecieveTime <>", value, "recievetime");
            return (Criteria) this;
        }

        public Criteria andRecievetimeGreaterThan(Date value) {
            addCriterion("RecieveTime >", value, "recievetime");
            return (Criteria) this;
        }

        public Criteria andRecievetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RecieveTime >=", value, "recievetime");
            return (Criteria) this;
        }

        public Criteria andRecievetimeLessThan(Date value) {
            addCriterion("RecieveTime <", value, "recievetime");
            return (Criteria) this;
        }

        public Criteria andRecievetimeLessThanOrEqualTo(Date value) {
            addCriterion("RecieveTime <=", value, "recievetime");
            return (Criteria) this;
        }

        public Criteria andRecievetimeIn(List<Date> values) {
            addCriterion("RecieveTime in", values, "recievetime");
            return (Criteria) this;
        }

        public Criteria andRecievetimeNotIn(List<Date> values) {
            addCriterion("RecieveTime not in", values, "recievetime");
            return (Criteria) this;
        }

        public Criteria andRecievetimeBetween(Date value1, Date value2) {
            addCriterion("RecieveTime between", value1, value2, "recievetime");
            return (Criteria) this;
        }

        public Criteria andRecievetimeNotBetween(Date value1, Date value2) {
            addCriterion("RecieveTime not between", value1, value2, "recievetime");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userId =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userId <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userId >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userId >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userId <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userId <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userId like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userId not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userId in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userId not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userId between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userId not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("`status` is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("`status` is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("`status` =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("`status` <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("`status` >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("`status` >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("`status` <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("`status` <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("`status` in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("`status` not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("`status` between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("`status` not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrIsNull() {
            addCriterion("deliveryAddr is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrIsNotNull() {
            addCriterion("deliveryAddr is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrEqualTo(String value) {
            addCriterion("deliveryAddr =", value, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrNotEqualTo(String value) {
            addCriterion("deliveryAddr <>", value, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrGreaterThan(String value) {
            addCriterion("deliveryAddr >", value, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryAddr >=", value, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrLessThan(String value) {
            addCriterion("deliveryAddr <", value, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrLessThanOrEqualTo(String value) {
            addCriterion("deliveryAddr <=", value, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrLike(String value) {
            addCriterion("deliveryAddr like", value, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrNotLike(String value) {
            addCriterion("deliveryAddr not like", value, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrIn(List<String> values) {
            addCriterion("deliveryAddr in", values, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrNotIn(List<String> values) {
            addCriterion("deliveryAddr not in", values, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrBetween(String value1, String value2) {
            addCriterion("deliveryAddr between", value1, value2, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andDeliveryaddrNotBetween(String value1, String value2) {
            addCriterion("deliveryAddr not between", value1, value2, "deliveryaddr");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeIsNull() {
            addCriterion("restRecieveTime is null");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeIsNotNull() {
            addCriterion("restRecieveTime is not null");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeEqualTo(Date value) {
            addCriterion("restRecieveTime =", value, "restrecievetime");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeNotEqualTo(Date value) {
            addCriterion("restRecieveTime <>", value, "restrecievetime");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeGreaterThan(Date value) {
            addCriterion("restRecieveTime >", value, "restrecievetime");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("restRecieveTime >=", value, "restrecievetime");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeLessThan(Date value) {
            addCriterion("restRecieveTime <", value, "restrecievetime");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeLessThanOrEqualTo(Date value) {
            addCriterion("restRecieveTime <=", value, "restrecievetime");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeIn(List<Date> values) {
            addCriterion("restRecieveTime in", values, "restrecievetime");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeNotIn(List<Date> values) {
            addCriterion("restRecieveTime not in", values, "restrecievetime");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeBetween(Date value1, Date value2) {
            addCriterion("restRecieveTime between", value1, value2, "restrecievetime");
            return (Criteria) this;
        }

        public Criteria andRestrecievetimeNotBetween(Date value1, Date value2) {
            addCriterion("restRecieveTime not between", value1, value2, "restrecievetime");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyIsNull() {
            addCriterion("delieveryCompany is null");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyIsNotNull() {
            addCriterion("delieveryCompany is not null");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyEqualTo(String value) {
            addCriterion("delieveryCompany =", value, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyNotEqualTo(String value) {
            addCriterion("delieveryCompany <>", value, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyGreaterThan(String value) {
            addCriterion("delieveryCompany >", value, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyGreaterThanOrEqualTo(String value) {
            addCriterion("delieveryCompany >=", value, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyLessThan(String value) {
            addCriterion("delieveryCompany <", value, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyLessThanOrEqualTo(String value) {
            addCriterion("delieveryCompany <=", value, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyLike(String value) {
            addCriterion("delieveryCompany like", value, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyNotLike(String value) {
            addCriterion("delieveryCompany not like", value, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyIn(List<String> values) {
            addCriterion("delieveryCompany in", values, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyNotIn(List<String> values) {
            addCriterion("delieveryCompany not in", values, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyBetween(String value1, String value2) {
            addCriterion("delieveryCompany between", value1, value2, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDelieverycompanyNotBetween(String value1, String value2) {
            addCriterion("delieveryCompany not between", value1, value2, "delieverycompany");
            return (Criteria) this;
        }

        public Criteria andDeliveryidIsNull() {
            addCriterion("deliveryId is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryidIsNotNull() {
            addCriterion("deliveryId is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryidEqualTo(String value) {
            addCriterion("deliveryId =", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotEqualTo(String value) {
            addCriterion("deliveryId <>", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidGreaterThan(String value) {
            addCriterion("deliveryId >", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidGreaterThanOrEqualTo(String value) {
            addCriterion("deliveryId >=", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidLessThan(String value) {
            addCriterion("deliveryId <", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidLessThanOrEqualTo(String value) {
            addCriterion("deliveryId <=", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidLike(String value) {
            addCriterion("deliveryId like", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotLike(String value) {
            addCriterion("deliveryId not like", value, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidIn(List<String> values) {
            addCriterion("deliveryId in", values, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotIn(List<String> values) {
            addCriterion("deliveryId not in", values, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidBetween(String value1, String value2) {
            addCriterion("deliveryId between", value1, value2, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDeliveryidNotBetween(String value1, String value2) {
            addCriterion("deliveryId not between", value1, value2, "deliveryid");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyIsNull() {
            addCriterion("decreaseMoney is null");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyIsNotNull() {
            addCriterion("decreaseMoney is not null");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyEqualTo(Double value) {
            addCriterion("decreaseMoney =", value, "decreasemoney");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyNotEqualTo(Double value) {
            addCriterion("decreaseMoney <>", value, "decreasemoney");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyGreaterThan(Double value) {
            addCriterion("decreaseMoney >", value, "decreasemoney");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyGreaterThanOrEqualTo(Double value) {
            addCriterion("decreaseMoney >=", value, "decreasemoney");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyLessThan(Double value) {
            addCriterion("decreaseMoney <", value, "decreasemoney");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyLessThanOrEqualTo(Double value) {
            addCriterion("decreaseMoney <=", value, "decreasemoney");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyIn(List<Double> values) {
            addCriterion("decreaseMoney in", values, "decreasemoney");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyNotIn(List<Double> values) {
            addCriterion("decreaseMoney not in", values, "decreasemoney");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyBetween(Double value1, Double value2) {
            addCriterion("decreaseMoney between", value1, value2, "decreasemoney");
            return (Criteria) this;
        }

        public Criteria andDecreasemoneyNotBetween(Double value1, Double value2) {
            addCriterion("decreaseMoney not between", value1, value2, "decreasemoney");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIsNull() {
            addCriterion("orderPrice is null");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIsNotNull() {
            addCriterion("orderPrice is not null");
            return (Criteria) this;
        }

        public Criteria andOrderpriceEqualTo(Double value) {
            addCriterion("orderPrice =", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotEqualTo(Double value) {
            addCriterion("orderPrice <>", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceGreaterThan(Double value) {
            addCriterion("orderPrice >", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("orderPrice >=", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLessThan(Double value) {
            addCriterion("orderPrice <", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceLessThanOrEqualTo(Double value) {
            addCriterion("orderPrice <=", value, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceIn(List<Double> values) {
            addCriterion("orderPrice in", values, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotIn(List<Double> values) {
            addCriterion("orderPrice not in", values, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceBetween(Double value1, Double value2) {
            addCriterion("orderPrice between", value1, value2, "orderprice");
            return (Criteria) this;
        }

        public Criteria andOrderpriceNotBetween(Double value1, Double value2) {
            addCriterion("orderPrice not between", value1, value2, "orderprice");
            return (Criteria) this;
        }
    }

    /**
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}