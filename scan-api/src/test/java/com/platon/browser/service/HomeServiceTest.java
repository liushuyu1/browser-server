package com.platon.browser.service;


import com.platon.browser.ApiTestMockBase;
import com.platon.browser.request.home.QueryNavigationRequest;
import com.platon.browser.response.home.BlockStatisticNewResp;
import com.platon.browser.response.home.ChainStatisticNewResp;
import com.platon.browser.response.home.QueryNavigationResp;
import com.platon.browser.response.home.StakingListNewResp;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.util.ReflectionTestUtils;

import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.Silent.class)
public class HomeServiceTest extends ApiTestMockBase {
    @Spy
    private HomeService target;
    @Spy
    private CommonService service;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(target, "statisticCacheService", statisticCacheService);
        ReflectionTestUtils.setField(target, "ESBlockRepository", ESBlockRepository);
        ReflectionTestUtils.setField(target, "ESTransactionRepository", ESTransactionRepository);
        ReflectionTestUtils.setField(target, "nodeMapper", nodeMapper);
        ReflectionTestUtils.setField(target, "addressMapper", addressMapper);
        ReflectionTestUtils.setField(target, "blockChainConfig", blockChainConfig);
        ReflectionTestUtils.setField(target, "commonService", commonService);
        ReflectionTestUtils.setField(target, "customNodeMapper", customNodeMapper);
        ReflectionTestUtils.setField(target, "networkParams", networkParams);
        ReflectionTestUtils.setField(service, "customNodeMapper", customNodeMapper);
    }

    @Test
    public void stakingListNew() {
        StakingListNewResp list = target.stakingListNew();
        assertNotNull(list);
    }

    @Test
    public void testQueryNavigation() throws IOException {
        QueryNavigationResp list;
        QueryNavigationRequest req = new QueryNavigationRequest();
        req.setParameter("3");
        list = target.queryNavigation(req);
        try {
            req.setParameter("a");
            list = target.queryNavigation(req);
        } catch (Exception e) {

        }

        req.setParameter("0x77fffc999d9f9403b65009f1eb27bae65774e2d8ea36f7b20a89f82642a5067557430e6edfe5320bb81c3666a19cf4a5172d6533117d7ebcd0f2c82055499050");
        list = target.queryNavigation(req);

        req.setParameter("77fffc999d9f9403b65009f1eb27bae65774e2d8ea36f7b20a89f82642a5067557430e6edfe5320bb81c3666a19cf4a5172d6533117d7ebcd0f2c82055499050");
        list = target.queryNavigation(req);

        req.setParameter("atp1vr8v48qjjrh9dwvdfctqauz98a7yp5segddvme");
        list = target.queryNavigation(req);

        req.setParameter("0x9bf480e19c921c93cfc30e2e1d5d67b02b65b89f1f68a675e782ec46478fe228");
        list = target.queryNavigation(req);

        when(ESTransactionRepository.get(any(), any())).thenReturn(null);
        req.setParameter("0x9bf480e19c921c93cfc30e2e1d5d67b02b65b89f1f68a675e782ec46478fe228");
        list = target.queryNavigation(req);
        assertNotNull(list);
    }

    @Test
    public void testChainStatisticNew() throws IOException {
        when(statisticCacheService.getNetworkStatCache()).thenReturn(null);
        ChainStatisticNewResp chainStatisticNewResp = target.chainStatisticNew();
        assertNotNull(chainStatisticNewResp);
    }

    @Test
    public void testBlockStatisticNew() throws IOException {
        BlockStatisticNewResp blockStatisticNewResp = target.blockStatisticNew();
        assertNotNull(blockStatisticNewResp);
    }

    @Test
    public void testCommonService() throws IOException {
        service.getNodeName("0x", "test");
        when(customNodeMapper.findNameById("0x")).thenReturn("test");
        service.getNodeName("0x", "");
    }
}