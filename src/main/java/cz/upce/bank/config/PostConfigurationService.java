package cz.upce.bank.config;


import mk.gridlib.domain.grid.GridConfig;
import mk.gridlib.service.interfaces.GridService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class PostConfigurationService {

    @Autowired
    private GridService gridService;

    @Autowired
    private ApplicationContext appContext;

    @EventListener(ApplicationReadyEvent.class)
    public void onAppReady() {
        initGrids();
    }

    private void initGrids() {
        Map<String, GridConfig> grids =  appContext.getBeansOfType(GridConfig.class);
        for (GridConfig config : grids.values()){
            gridService.addGridConfig(config);
        }
        gridService.initGrids();
    }
}
