package hms.service.hub.core.service;

import hms.service.hub.orm.model.Area;

import java.util.List;

/**
 * Created by chathura on 7/27/16.
 */
public interface AreaService {
    long saveArea(Area area);

    List<Area> getAllArea();

    Area getAreaById(long id);

    List<Area> getAreas(List<Long> areaIds);
}
