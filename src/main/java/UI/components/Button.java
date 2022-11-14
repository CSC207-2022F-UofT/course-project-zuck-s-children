package UI.components;

public class Button {
    public String description;

    public boolean isSelected() {
        return selected;
    }

    public boolean selected;
    public Button(String description) {
        this.description = description;
    }
    public void changeSelectionStatus() {
        if (selected) {
            this.selected = false;
        }
        else {this.selected = true;}
    }
    public String toString(){return description;}
}
