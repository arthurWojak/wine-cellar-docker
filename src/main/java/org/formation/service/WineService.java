package org.formation.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import org.formation.dto.WineDTO;
import org.formation.entity.Wine;
import org.formation.repository.WineRepository;

import java.util.List;

@ApplicationScoped
public class WineService {

    private final WineRepository wineRepository;

    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public List<WineDTO> getAllWines() {
        return this.wineRepository.streamAll()
                .map(Wine::toDTO)
                .toList();
    }

    public WineDTO getWine(Long id) throws NotFoundException  {
        return this.wineRepository.findByIdOptional(id)
                .map(Wine::toDTO)
                .orElseThrow(NotFoundException::new);
    }

    @Transactional
    public WineDTO createWine(WineDTO wineDTO) {
        Wine wine = new Wine();

        wine.setName(wineDTO.getName());
        wine.setYear(wineDTO.getYear());
        wine.setFamily(wineDTO.getFamily());
        wine.setVariety(wineDTO.getVariety());
        wine.setPrice(wineDTO.getPrice());

        wineRepository.persist(wine);

        return wine.toDTO();
    }

    @Transactional
    public WineDTO updateWine(Long id, WineDTO wineDTO) throws NotFoundException {
        Wine wine = wineRepository.findByIdOptional(id)
                .orElseThrow(NotFoundException::new);

        wine.setName(wineDTO.getName());
        wine.setYear(wineDTO.getYear());
        wine.setFamily(wineDTO.getFamily());
        wine.setVariety(wineDTO.getVariety());
        wine.setPrice(wineDTO.getPrice());

        wineRepository.persistAndFlush(wine);

        return wine.toDTO();
    }

    @Transactional
    public void deleteWine(Long id) {
        this.wineRepository.deleteById(id);
    }
}
