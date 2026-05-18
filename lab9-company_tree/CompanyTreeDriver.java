public class CompanyTreeDriver {
    public static void main(String[] args) {
        // 1. Build the Tree
        // Create the root node (e.g., "CEO")
        GeneralTreeNode root = new GeneralTreeNode("CEO");

        // Create department heads (children of root)
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering = new GeneralTreeNode("VP of Engineering");
        root.addChild(vpSales);
        root.addChild(vpEngineering);

        // --- TO BE COMPLETED BY STUDENT ---
        // Add more nodes to build the following hierarchy:
        //
        // CEO
        // |-- VP of Sales
        // | |-- Sales Manager (NA)
        // | |-- Sales Manager (EU)
        // |
        // |-- VP of Engineering
        // |-- Dev Team Lead
        // | |-- Developer 1
        // | |-- Developer 2
        // |
        // |-- QA Team Lead

        // Example for "VP of Sales" children:
        // GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        // GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        // vpSales.addChild(salesNA);
        // vpSales.addChild(salesEU);

        // ... add children for "VP of Engineering" ...

        GeneralTreeNode salesNA = new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);

        GeneralTreeNode devTeamLead = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode qaTeamLead = new GeneralTreeNode("QA Team Lead");
        vpEngineering.addChild(devTeamLead);
        vpEngineering.addChild(qaTeamLead);

        GeneralTreeNode developer1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode developer2 = new GeneralTreeNode("Developer 2");
        devTeamLead.addChild(developer1);
        devTeamLead.addChild(developer2);

        // 2. Perform Traversals
        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();

        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}