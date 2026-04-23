public class JavaBasic {

    // a. Tổng các phần tử âm trong mảng
    public static int sumNegativeElements(int[] a) {
        int sum = 0;
        for (int num : a) {
            if (num < 0) {
                sum += num;
            }
        }
        return sum;
    }

    // b. In hoa ký tự đầu tiên của mỗi từ nếu là nguyên âm (a, e, i, o, u)
    public static String uppercaseFirstVowels(String str) {
        if (str == null || str.isEmpty()) return str;
        String[] words = str.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (!word.isEmpty()) {
                char firstChar = word.charAt(0);
                if (firstChar == 'a' || firstChar == 'e' || firstChar == 'i' || firstChar == 'o' || firstChar == 'u') {
                    word = Character.toUpperCase(firstChar) + word.substring(1);
                }
            }
            result.append(word).append(" ");
        }
        // Xóa khoảng trắng cuối cùng
        return result.toString().trim();
    }

    // c. Vị trí số âm nhỏ nhất trong mảng (nếu không có số âm trả về -1)
    public static int findMinNegativeElement(int[] a) {
        int minIndex = -1;
        int minValue = 0; // giá trị tạm, sẽ cập nhật khi gặp số âm đầu tiên
        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0) {
                if (minIndex == -1 || a[i] < minValue) {
                    minValue = a[i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    // d. Tách phần tên từ chuỗi định dạng "Ho ten: <tên>"
    public static String getName(String str) {
        String prefix = "Ho ten: ";
        if (str.startsWith(prefix)) {
            return str.substring(prefix.length()).trim();
        }
        return "";
    }

    // e. Vị trí đầu tiên của số chia hết cho 3 (không có trả về -1)
    public static int findFirstMod3Element(int[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] % 3 == 0) {
                return i;
            }
        }
        return -1;
    }

    // f. Đếm số lần xuất hiện của từ k trong chuỗi str (không phân biệt hoa thường)
    public static int countString(String str, String k) {
        if (str == null || k == null) return 0;
        String[] words = str.split(" ");
        int count = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(k)) {
                count++;
            }
        }
        return count;
    }

    // Hàm main kiểm thử
    public static void main(String[] args) {
        // Kiểm tra câu a
        int[] arr = {1, -2, 3, 4, -2, 1, -9};
        System.out.println("Tong so am: " + sumNegativeElements(arr)); // -13

        // Kiểm tra câu b
        String s = "nguyen thi uyen an";
        System.out.println("Chuoi in hoa nguyen am dau: " + uppercaseFirstVowels(s));
        // Kết quả mong đợi: "nguyen thi Uyen An"

        // Kiểm tra câu c
        System.out.println("Vi tri so am nho nhat: " + findMinNegativeElement(arr)); // 6 (vi -9 nho nhat)

        // Kiểm tra câu d
        String s1 = "Ho ten: Nguyen Thi Anh Dao";
        System.out.println("Ten: " + getName(s1)); // Nguyen Thi Anh Dao

        // Kiểm tra câu e
        System.out.println("Vi tri dau tien chia het cho 3: " + findFirstMod3Element(arr)); // 0 (vi 1 khong chia het, -2 khong, 3 chia het tai vi tri 2)

        // Kiểm tra câu f
        String s2 = "Nguyen Phuong Hoang Anh Phuong Oanh";
        System.out.println("So lan xuat hien tu 'Phuong': " + countString(s2, "Phuong")); // 2
        System.out.println("So lan xuat hien tu 'phuong': " + countString(s2, "phuong")); // 2 (khong phan biet hoa thuong)
    }
}
