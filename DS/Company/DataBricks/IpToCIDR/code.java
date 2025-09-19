class Solution {
    public List<String> ipToCIDR(String ip, int n) {
        long start = ipToLong(ip); // Convert IP to long
        List<String> result = new ArrayList<>();

        while (n > 0) {
            long lowbit = start & -start; // Alignment constraint
            long maxBlock = 1L << (32 - (int)(Math.log(n) / Math.log(2))); // Limit by remaining n

            long blockSize = Math.min(lowbit, maxBlock);

            // CIDR prefix
            int prefix = 32 - (int)(Math.log(blockSize) / Math.log(2));
            result.add(longToIp(start) + "/" + prefix);

            start += blockSize;
            n -= blockSize;
        }

        return result;
    }

    // Helper: Convert dotted IP to long
    private long ipToLong(String ip) {
        String[] parts = ip.split("\\.");
        long res = 0;
        for (String part : parts) {
            res = res * 256 + Integer.parseInt(part);
        }
        return res;
    }

    // Helper: Convert long back to dotted IP
    private String longToIp(long num) {
        return String.format("%d.%d.%d.%d",
                (num >> 24) & 255,
                (num >> 16) & 255,
                (num >> 8) & 255,
                num & 255);
    }
}
