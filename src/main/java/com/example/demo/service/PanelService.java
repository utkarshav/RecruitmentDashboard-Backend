package com.example.demo.service;

import com.example.demo.entity.Panel;
import com.example.demo.repository.PanelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PanelService {

    @Autowired
    private PanelRepository panelRepository;

    public List<Panel> getAllPanel() {
        return panelRepository.findAll();
    }

    public Optional<Panel> getPanelById(int id) {
        return panelRepository.findById(id);
    }

    public Panel createPanel(Panel panel) {
        return panelRepository.save(panel);
    }

    public Panel updatePanel(int id, Panel panel) {
        Optional<Panel> existingPanel = panelRepository.findById(id);
        if (existingPanel.isPresent()) {
            panel.setId(id);
            return panelRepository.save(panel);
        } else {
            // Handle the case where the panel with the given id is not found
            return null;
        }
    }

    public void deletePanel(int id) {
        panelRepository.deleteById(id);
    }
}
