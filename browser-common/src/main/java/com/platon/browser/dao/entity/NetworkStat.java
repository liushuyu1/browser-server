package com.platon.browser.dao.entity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class NetworkStat {
    private Integer id;

    private Long currentNumber;

    private String nodeName;

    private String nodeId;

    private Integer txQty;

    private Integer currentTps;

    private Integer maxTps;

    private String issueValue;

    private String turnValue;

    private String stakingDelegationValue;

    private String stakingValue;

    private Integer proposalQty;

    private Integer doingProposalQty;

    private Integer addressQty;

    private String blockReward;

    private String stakingReward;

    private Long addIssueBegin;

    private Long addIssueEnd;

    private Long nextSetting;

    private Date createTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Long getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(Long currentNumber) {
        this.currentNumber = currentNumber;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId == null ? null : nodeId.trim();
    }

    public Integer getTxQty() {
        return txQty;
    }

    public void setTxQty(Integer txQty) {
        this.txQty = txQty;
    }

    public Integer getCurrentTps() {
        return currentTps;
    }

    public void setCurrentTps(Integer currentTps) {
        this.currentTps = currentTps;
    }

    public Integer getMaxTps() {
        return maxTps;
    }

    public void setMaxTps(Integer maxTps) {
        this.maxTps = maxTps;
    }

    public String getIssueValue() {
        return issueValue;
    }

    public void setIssueValue(String issueValue) {
        this.issueValue = issueValue == null ? null : issueValue.trim();
    }

    public String getTurnValue() {
        return turnValue;
    }

    public void setTurnValue(String turnValue) {
        this.turnValue = turnValue == null ? null : turnValue.trim();
    }

    public String getStakingDelegationValue() {
        return stakingDelegationValue;
    }

    public void setStakingDelegationValue(String stakingDelegationValue) {
        this.stakingDelegationValue = stakingDelegationValue == null ? null : stakingDelegationValue.trim();
    }

    public String getStakingValue() {
        return stakingValue;
    }

    public void setStakingValue(String stakingValue) {
        this.stakingValue = stakingValue == null ? null : stakingValue.trim();
    }

    public Integer getProposalQty() {
        return proposalQty;
    }

    public void setProposalQty(Integer proposalQty) {
        this.proposalQty = proposalQty;
    }

    public Integer getDoingProposalQty() {
        return doingProposalQty;
    }

    public void setDoingProposalQty(Integer doingProposalQty) {
        this.doingProposalQty = doingProposalQty;
    }

    public Integer getAddressQty() {
        return addressQty;
    }

    public void setAddressQty(Integer addressQty) {
        this.addressQty = addressQty;
    }

    public String getBlockReward() {
        return blockReward;
    }

    public void setBlockReward(String blockReward) {
        this.blockReward = blockReward == null ? null : blockReward.trim();
    }

    public String getStakingReward() {
        return stakingReward;
    }

    public void setStakingReward(String stakingReward) {
        this.stakingReward = stakingReward == null ? null : stakingReward.trim();
    }

    public Long getAddIssueBegin() {
        return addIssueBegin;
    }

    public void setAddIssueBegin(Long addIssueBegin) {
        this.addIssueBegin = addIssueBegin;
    }

    public Long getAddIssueEnd() {
        return addIssueEnd;
    }

    public void setAddIssueEnd(Long addIssueEnd) {
        this.addIssueEnd = addIssueEnd;
    }

    public Long getNextSetting() {
        return nextSetting;
    }

    public void setNextSetting(Long nextSetting) {
        this.nextSetting = nextSetting;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This enum was generated by MyBatis Generator.
     * This enum corresponds to the database table network_stat
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    public enum Column {
        id("id", "id", "INTEGER", false),
        currentNumber("current_number", "currentNumber", "BIGINT", false),
        nodeName("node_name", "nodeName", "VARCHAR", false),
        nodeId("node_id", "nodeId", "VARCHAR", false),
        txQty("tx_qty", "txQty", "INTEGER", false),
        currentTps("current_tps", "currentTps", "INTEGER", false),
        maxTps("max_tps", "maxTps", "INTEGER", false),
        issueValue("issue_value", "issueValue", "VARCHAR", false),
        turnValue("turn_value", "turnValue", "VARCHAR", false),
        stakingDelegationValue("staking_delegation_value", "stakingDelegationValue", "VARCHAR", false),
        stakingValue("staking_value", "stakingValue", "VARCHAR", false),
        proposalQty("proposal_qty", "proposalQty", "INTEGER", false),
        doingProposalQty("doing_proposal_qty", "doingProposalQty", "INTEGER", false),
        addressQty("address_qty", "addressQty", "INTEGER", false),
        blockReward("block_reward", "blockReward", "VARCHAR", false),
        stakingReward("staking_reward", "stakingReward", "VARCHAR", false),
        addIssueBegin("add_issue_begin", "addIssueBegin", "BIGINT", false),
        addIssueEnd("add_issue_end", "addIssueEnd", "BIGINT", false),
        nextSetting("next_setting", "nextSetting", "BIGINT", false),
        createTime("create_time", "createTime", "TIMESTAMP", false),
        updateTime("update_time", "updateTime", "TIMESTAMP", false);

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String BEGINNING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private static final String ENDING_DELIMITER = "`";

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String column;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final boolean isColumnNameDelimited;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String javaProperty;

        /**
         * This field was generated by MyBatis Generator.
         * This field corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        private final String jdbcType;

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String value() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getValue() {
            return this.column;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJavaProperty() {
            return this.javaProperty;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getJdbcType() {
            return this.jdbcType;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        Column(String column, String javaProperty, String jdbcType, boolean isColumnNameDelimited) {
            this.column = column;
            this.javaProperty = javaProperty;
            this.jdbcType = jdbcType;
            this.isColumnNameDelimited = isColumnNameDelimited;
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String desc() {
            return this.getEscapedColumnName() + " DESC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String asc() {
            return this.getEscapedColumnName() + " ASC";
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public static Column[] excludes(Column ... excludes) {
            ArrayList<Column> columns = new ArrayList<>(Arrays.asList(Column.values()));
            if (excludes != null && excludes.length > 0) {
                columns.removeAll(new ArrayList<>(Arrays.asList(excludes)));
            }
            return columns.toArray(new Column[]{});
        }

        /**
         * This method was generated by MyBatis Generator.
         * This method corresponds to the database table network_stat
         *
         * @mbg.generated
         * @project https://github.com/itfsw/mybatis-generator-plugin
         */
        public String getEscapedColumnName() {
            if (this.isColumnNameDelimited) {
                return new StringBuilder().append(BEGINNING_DELIMITER).append(this.column).append(ENDING_DELIMITER).toString();
            } else {
                return this.column;
            }
        }
    }
}