class test {
	public static void main(String[] args) {
		Point pt1 = new Point(3,3);
		Point pt2 = new Point(6,3);
		Circle cir1 = new Circle(pt1, 3);
		Circle cir2 = new Circle(pt2, 3);
		IntersectRegion intersecttest = new IntersectRegion(cir1, cir2);
		intersecttest.fillGrid();
		intersecttest.draw();
	}
}	