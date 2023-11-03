package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
  int rated_capacity = 120;
  for (int i = 0; i < presentCapacities.length; i++) {
    double SoH = 100.0 * presentCapacities[i] / rated_capacity;
    if (SoH > 80) {
      counts.healthy += 1;
    } else if (SoH >= 62) {
      counts.exchange += 1;
    } else {
      counts.failed += 1;
    }
  }
  return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {113, 116, 80, 95, 92, 70};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
