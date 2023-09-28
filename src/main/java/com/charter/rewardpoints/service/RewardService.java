package com.charter.rewardpoints.service;

import com.charter.rewardpoints.dto.Reward;
import com.charter.rewardpoints.entity.Transaction;
import com.charter.rewardpoints.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RewardService {

    private TransactionRepository transactionRepository;

    public RewardService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Reward getCustomerRewards(Long customerId){
        Timestamp lastMonthTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(30));
       // first month
        List<Transaction> lastMonthTransactions = transactionRepository.findAllByCustomerIdAndTransactionDateBetween(
                customerId, lastMonthTimestamp, Timestamp.from(Instant.now()));
        Long lastMonthRewardPoints = calculatePerMonth(lastMonthTransactions);
        //second month
        Timestamp lastSecondMonthTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(60));
        List<Transaction> lastSecondMonthTransactions = transactionRepository
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastSecondMonthTimestamp, lastMonthTimestamp);
        Long lastSecondMonthRewardPoints = calculatePerMonth(lastSecondMonthTransactions);
        //third month
        Timestamp lastThirdMonthTimestamp = Timestamp.valueOf(LocalDateTime.now().minusDays(90));
        List<Transaction> lastThirdMonthTransactions = transactionRepository
                .findAllByCustomerIdAndTransactionDateBetween(customerId, lastThirdMonthTimestamp,
                        lastSecondMonthTimestamp);
        Long lastThirdMonthRewardPoints = calculatePerMonth(lastThirdMonthTransactions);

        Reward reward = new Reward();
        reward.setCustomerId(customerId);
        reward.setLastMonthRewardPoints(lastMonthRewardPoints);
        reward.setLastSecondMonthRewardPoints(lastSecondMonthRewardPoints);
        reward.setLastThirdMonthRewardPoints(lastThirdMonthRewardPoints);
        reward.setTotalRewards(lastMonthRewardPoints + lastSecondMonthRewardPoints + lastThirdMonthRewardPoints);

        return reward;
    }

    private Long calculatePerMonth(List<Transaction> transactions) {
        return transactions.stream().map(transaction -> calculateRewards(transaction))
                .collect(Collectors.summingLong(r -> r.longValue()));
    }

    private Long calculateRewards(Transaction t) {
        if (t.getTransactionAmount() > 50 && t.getTransactionAmount() <= 100) {
            return Math.round(t.getTransactionAmount() - 50);
        } else if (t.getTransactionAmount() > 100) {
            return Math.round(t.getTransactionAmount() - 100) * 2
                    + (100 - 50);
        } else
            return 0L;

    }


}
