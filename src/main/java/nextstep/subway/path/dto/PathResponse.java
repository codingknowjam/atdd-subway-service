package nextstep.subway.path.dto;

import java.math.BigDecimal;
import java.util.List;

import nextstep.subway.line.domain.Distance;
import nextstep.subway.path.domain.SubwayFare;
import nextstep.subway.station.dto.StationResponse;

public class PathResponse {

	private List<StationResponse> stations;
	private int distance;
	private int subwayFare;

	private PathResponse(List<StationResponse> stationResponses, int distance, int subwayFare) {
		this.stations = stationResponses;
		this.distance = distance;
		this.subwayFare = subwayFare;
	}

	public static PathResponse of(PathFinderResponse pathFinderResponse) {
		return new PathResponse(
			pathFinderResponse.getStationResponses(),
			pathFinderResponse.getDistance().value(),
			pathFinderResponse.getSubwayFare().value());
	}

	public int getDistance() {
		return distance;
	}

	public List<StationResponse> getStations() {
		return stations;
	}

	public int getSubwayFare() {
		return subwayFare;
	}
}
