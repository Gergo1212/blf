package com.blf.gameservice.daodb;

import com.blf.gameservice.dao.StatisticDao;
import com.blf.gameservice.model.entity.StatisticalRow;
import com.blf.gameservice.repository.StatisticalRowRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StatisticDaoDB implements StatisticDao {

    private final StatisticalRowRepository statisticRepository;


    //TODO remove limiter
    @Override
    public List<StatisticalRow> getAllStatistics() {
        int limiter = 40;
        return statisticRepository.findAll().stream().limit(limiter).collect(Collectors.toList());
    }

    @Override
    public List<StatisticalRow> getAllStatisticsBySeasonId(Long seasonId) {
        return statisticRepository.findAllByPlayerSeasonId(seasonId);
    }

    @Override
    public StatisticalRow getStatisticById(Long statisticId) {
        return statisticRepository.findById(statisticId).orElse(null);
    }

    @Override
    public StatisticalRow addNewStatistic(StatisticalRow statisticalrow) {
        return statisticRepository.saveAndFlush(statisticalrow);
    }

    @Override
    public void updateStatistic(StatisticalRow updatedStatisticalRow) {
        statisticRepository.saveAndFlush(updatedStatisticalRow);
    }

    @Override
    public StatisticalRow deleteStatistic(Long statisticId) {
        StatisticalRow statToDelete = statisticRepository.findById(statisticId).orElse(null);
        statisticRepository.deleteById(statisticId);
        log.info("Deleted statistic: " + statToDelete);
        return statToDelete;
    }
}
