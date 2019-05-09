package application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import application.model.AvoirFrais;
import application.model.AvoirFraisPK;
import application.model.Mission;
import application.model.Missionnaire;

@Repository
public interface AvoirFraisRepository extends JpaRepository<AvoirFrais, Class<AvoirFraisPK>> {
	
	@Query("select o from AvoirFrais  a , OrdMis o , Mission m where a.ordMis.numMission=o.mission.numMission and o.mission.numMission=m.numMission and m.numMission=:num")
	public List<AvoirFrais> getFraisByMission(@Param("num")String num);
	@Query("select a from AvoirFrais a where a.ordMis.code=:codeDept and a.numMission=:numMission and a.cin =:cin and a.numord=:numOrd ")
	public List<AvoirFrais> getFraisMission(@Param("codeDept")String codeDept,@Param("numMission") String numMission,@Param("cin") String cin,@Param("numOrd") Short numOrd);
	
	}
