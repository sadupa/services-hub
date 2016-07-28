package hms.service.hub.web.controller;

import hms.service.hub.core.dto.ServiceRequestDto;
import hms.service.hub.core.service.ServiceRequestService;
import hms.service.hub.orm.model.ServiceRequest;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;


@Controller
public class ServiceRequestController {

    @Autowired
    ServiceRequestService serviceRequestService;

    @RequestMapping(value = "/postRequest", method = RequestMethod.GET)
    public String requestForm(Model model) {
        model.addAttribute("postRequest", new ServiceRequest());
        return "postRequest";
    }

    @RequestMapping(value = "/postRequest", method = RequestMethod.POST)
    public String requestFormSubmit(@ModelAttribute ServiceRequest serviceRequest, Model model) {
        model.addAttribute("PostRequest", serviceRequest);
        return "result";
    }

    @RequestMapping(value = "/view", method = RequestMethod.GET)
    public String viewServiceRequests(@RequestParam("area") long area, @RequestParam("category") long category,
                                      @RequestParam("keyword") String keyword,ModelMap model) {
        Random rand = new Random();

        List<ServiceRequest> serviceRequests = serviceRequestService.getServiceRequest(area, category, keyword);
        List<ServiceRequestDto> serviceRequestDtos = new ArrayList<>();
        for (ServiceRequest serviceRequest : serviceRequests) {
            serviceRequestDtos.add(new ServiceRequestDto(rand.nextInt(5) + 1,serviceRequest.getTitle(),getFirstTwenty(serviceRequest.getDescription()),serviceRequest.getArea().getName(),
                    DurationFormatUtils.formatDurationWords(new Date().getTime() -  serviceRequest.getCreatedDate().getTime(), true, false)));
        }

        model.put("service",serviceRequestDtos);
        return "services";
    }

    public String getFirstTwenty(String input ){
        if(input.length() > 50){
            return input.substring(0,50);
        }else {
            return input;
        }
    }

}
