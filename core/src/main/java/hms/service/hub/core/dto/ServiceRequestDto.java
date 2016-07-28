package hms.service.hub.core.dto;

import java.util.Date;

/**
 * Created by chathura on 7/27/16.
 */
public class ServiceRequestDto {

    public String title;
    public String description;
    public String area;
    public String createdOn;

    public ServiceRequestDto() {
    }

    public ServiceRequestDto(String title, String description, String area, String createdOn) {
        this.title = title;
        this.description = description;
        this.area = area;
        this.createdOn = createdOn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
