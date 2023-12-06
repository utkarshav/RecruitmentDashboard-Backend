package com.example.demo.controller;

import com.example.demo.entity.Panel;
import com.example.demo.service.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/panel")
public class PanelController
{
    @Autowired
    PanelService panelService;

    @GetMapping("/getAllPanels")
    public List<Panel> getALLPanel()
    {
        return panelService.getAllPanel();
    }

    @PostMapping("/createPanel")
    public Panel createPanel(@RequestBody Panel panel)
    {
        Panel panel1 = new Panel(panel.getMasterPositionId(),panel.getName(),panel.getInterviewsConducted(),panel.getDate());
        return panelService.createPanel(panel1);
    }

    @GetMapping("/getPanelById/{id}")
    public Optional<Panel> getPanelById(@PathVariable int id) {
      return panelService.getPanelById(id);
    }

    @PutMapping("/updatePanelById/{id}")
    public Panel updatePanel(@PathVariable int id, @RequestBody Panel panel)
    {
        return panelService.updatePanel(id, panel);
    }
}
