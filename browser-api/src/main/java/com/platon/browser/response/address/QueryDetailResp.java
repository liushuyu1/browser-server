package com.platon.browser.response.address;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.platon.browser.config.json.CustomLatSerializer;

/**
 *  查询地址的返回的对象
 *  @file QueryDetailResp.java
 *  @description 
 *	@author zhangrj
 *  @data 2019年8月31日
 */
public class QueryDetailResp {
	private Integer type;                //地址详情  1：账号   2：内置合约   3：EVM合约 4:WASM
    private BigDecimal balance;             //余额(单位:ATP)
    private BigDecimal restrictingBalance;  //锁仓余额(单位:ATP)
    private BigDecimal stakingValue;        //质押的金额
    private BigDecimal delegateValue;       //委托的金额
    private BigDecimal redeemedValue;       //赎回中的金额
    private Integer txQty;             //交易总数
    private Integer erc20TxQty; // token erc20交易总数
	private Integer erc721TxQty; // token erc 721交易总数
    private Integer transferQty;         //转账交易总数
    private Integer delegateQty;         //委托交易总数
    private Integer stakingQty;          //验证人交易总数
    private Integer proposalQty;         //治理交易总数
    private Integer candidateCount;      //已委托验证人
    private BigDecimal delegateHes;         //未锁定委托（ATP）
    private BigDecimal delegateLocked;      //已锁定委托（ATP）
    private BigDecimal delegateUnlock;      //已解除委托（ATP）
    private BigDecimal delegateReleased;    //待赎回委托（ATP）
    private BigDecimal delegateClaim;    //待提取委托（ATP）
    private BigDecimal haveReward;    //已提取委托（ATP）
    private String contractName;        //合约名称
    private String contractCreate;      //合约创建者地址
    private String contractCreateHash; //合约创建哈希
    private String contractBin; //合约bin
    private Integer isRestricting; //是否锁仓
    private Integer isDestroy; //是否销毁 
    private String destroyHash; //合约销毁哈希
	public Integer getType() {
		return this.type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getBalance() {
		return this.balance;
	}
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getRestrictingBalance() {
		return this.restrictingBalance;
	}
	public void setRestrictingBalance(BigDecimal restrictingBalance) {
		this.restrictingBalance = restrictingBalance;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getStakingValue() {
		return this.stakingValue;
	}
	public void setStakingValue(BigDecimal stakingValue) {
		this.stakingValue = stakingValue;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getDelegateValue() {
		return this.delegateValue;
	}
	public void setDelegateValue(BigDecimal delegateValue) {
		this.delegateValue = delegateValue;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getRedeemedValue() {
		return this.redeemedValue;
	}
	public void setRedeemedValue(BigDecimal redeemedValue) {
		this.redeemedValue = redeemedValue;
	}
	public Integer getTxQty() {
		return this.txQty;
	}
	public void setTxQty(Integer txQty) {
		this.txQty = txQty;
	}
	public Integer getTransferQty() {
		return this.transferQty;
	}
	public void setTransferQty(Integer transferQty) {
		this.transferQty = transferQty;
	}
	public Integer getDelegateQty() {
		return this.delegateQty;
	}
	public void setDelegateQty(Integer delegateQty) {
		this.delegateQty = delegateQty;
	}
	public Integer getStakingQty() {
		return this.stakingQty;
	}
	public void setStakingQty(Integer stakingQty) {
		this.stakingQty = stakingQty;
	}
	public Integer getProposalQty() {
		return this.proposalQty;
	}
	public void setProposalQty(Integer proposalQty) {
		this.proposalQty = proposalQty;
	}
	public Integer getCandidateCount() {
		return this.candidateCount;
	}
	public void setCandidateCount(Integer candidateCount) {
		this.candidateCount = candidateCount;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getDelegateHes() {
		return this.delegateHes;
	}
	public void setDelegateHes(BigDecimal delegateHes) {
		this.delegateHes = delegateHes;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getDelegateLocked() {
		return this.delegateLocked;
	}
	public void setDelegateLocked(BigDecimal delegateLocked) {
		this.delegateLocked = delegateLocked;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getDelegateUnlock() {
		return this.delegateUnlock;
	}
	public void setDelegateUnlock(BigDecimal delegateUnlock) {
		this.delegateUnlock = delegateUnlock;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getDelegateReleased() {
		return this.delegateReleased;
	}
	public void setDelegateReleased(BigDecimal delegateReleased) {
		this.delegateReleased = delegateReleased;
	}
	public String getContractName() {
		return this.contractName;
	}
	public void setContractName(String contractName) {
		this.contractName = contractName;
	}
	public String getContractCreate() {
		return this.contractCreate;
	}
	public void setContractCreate(String contractCreate) {
		this.contractCreate = contractCreate;
	}
	public String getContractCreateHash() {
		return this.contractCreateHash;
	}
	public void setContractCreateHash(String contractCreateHash) {
		this.contractCreateHash = contractCreateHash;
	}
	public Integer getIsRestricting() {
		return this.isRestricting;
	}
	public void setIsRestricting(Integer isRestricting) {
		this.isRestricting = isRestricting;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getDelegateClaim() {
		return this.delegateClaim;
	}
	public void setDelegateClaim(BigDecimal delegateClaim) {
		this.delegateClaim = delegateClaim;
	}
	@JsonSerialize(using = CustomLatSerializer.class)
	public BigDecimal getHaveReward() {
		return this.haveReward;
	}
	public void setHaveReward(BigDecimal haveReward) {
		this.haveReward = haveReward;
	}
	public String getContractBin() {
		return this.contractBin;
	}
	public void setContractBin(String contractBin) {
		this.contractBin = contractBin;
	}
	public Integer getIsDestroy() {
		return this.isDestroy;
	}
	public void setIsDestroy(Integer isDestroy) {
		this.isDestroy = isDestroy;
	}
	public String getDestroyHash() {
		return this.destroyHash;
	}
	public void setDestroyHash(String destroyHash) {
		this.destroyHash = destroyHash;
	}

	public Integer getErc20TxQty() {
		return erc20TxQty;
	}

	public void setErc20TxQty(Integer erc20TxQty) {
		this.erc20TxQty = erc20TxQty;
	}

	public Integer getErc721TxQty() {
		return erc721TxQty;
	}

	public void setErc721TxQty(Integer erc721TxQty) {
		this.erc721TxQty = erc721TxQty;
	}
}
