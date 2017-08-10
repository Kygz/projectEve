package constants;

public class ShipAssemblyConstants {

    public enum Scope {

        UNION(0, "联盟制式"),
        LEGION(1, "军团制式"),
        TEAM(2, "小队制式"),
        PERSONAL(3, "个人秀");

        private int key;
        private String text;

        Scope(int key, String text) {
            this.key = key;
            this.text = text;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }

    public enum UseType {

        UNION(0, "PVP"),
        LEGION(1, "PVE");

        private int key;
        private String text;

        UseType(int key, String text) {
            this.key = key;
            this.text = text;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

    }
}
