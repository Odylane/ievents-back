package fr.formation.internalevents.services;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.formation.internalevents.dtos.RoomDto;
import fr.formation.internalevents.repositories.RoomRepository;

@Service
public class RoomServiceImpl implements RoomService {

	private final RoomRepository roomRepo;

	public RoomServiceImpl(RoomRepository roomRepo) {
		this.roomRepo = roomRepo;
	}

	@Override
	public List<RoomDto> getAll() {
		return roomRepo.getAllProjected();
	}
}
