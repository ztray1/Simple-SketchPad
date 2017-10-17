
package data;

public class LineParam {

	private ColorParam color;
	private Long roadSegmentId;
	private Integer size = 10;
	private PointParam start;
	private PointParam end;

	private Integer direction;

	public ColorParam getColor() {
		return color;
	}

	public void setColor(ColorParam color) {
		this.color = color;
	}

	public Long getRoadSegmentId() {
		return roadSegmentId;
	}

	public void setRoadSegmentId(Long roadSegmentId) {
		this.roadSegmentId = roadSegmentId;
	}

	public Integer getSize() {
		return size;
	}

	public void setSize(Integer size) {
		this.size = size;
	}

	public PointParam getStart() {
		return start;
	}

	public void setStart(PointParam start) {
		this.start = start;
	}

	public PointParam getEnd() {
		return end;
	}

	public void setEnd(PointParam end) {
		this.end = end;
	}

	public Integer getDirection() {
		return direction;

	}

	public void setDirection(Integer direction) {
		this.direction = direction;
	}

}
