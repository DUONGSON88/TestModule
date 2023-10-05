package view;

import manager.ProductsManager;
import model.Product;
import validate.Validator;

public class MenuManager {
    ProductsManager productsManager = new ProductsManager();

    public void showMenu() {

        int choice;
        do {
            System.out.println("=====Quản Lý Sản Phẩm=====");
            System.out.println("1.Thêm mới Sản Phẩm.");
            System.out.println("2.Sửa sản phẩm theo id.");
            System.out.println("3.Xóa sản phẩm theo id.");
            System.out.println("4.Hiển thị tất cả sản phẩm.");
            System.out.println("5.Tìm kiếm sản phẩm theo tên gần đúng.");
            System.out.println("6.Tìm kiếm sản phẩm theo loại.");
            System.out.println("7.Tìm kiếm sản phẩm theo id.");
            System.out.println("0.Thoát ứng dụng");
            System.out.println("Hãy nhập lựa chọn của bạn:");
            choice = Validator.choice();
            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    showAllProduct();
                    break;
                case 5:
                    searchProductByName();
                    break;
                case 6:
                    searchProductByType();
                    break;
                case 7:
                    searchProductById();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println();
            }
        } while (choice != 0);
    }

    public void updateProduct() {
        System.out.println("Hãy nhập Id của sản phẩm bạn cần sửa thông tin:");
        int idEdit = Validator.inputInt();
        if (productsManager.findIndexById(idEdit) == -1) {
            System.out.println("Không tìm thấy sản phẩm có id " + idEdit);
        } else {
            System.out.println("Sửa thông tin của sản phẩm id " + idEdit);
            System.out.println("Nhập id : ");
            int id = Validator.inputInt();
            System.out.println("Nhập tên sản phẩm : ");
            String name = Validator.inputString();
            System.out.println("Nhập số lượng: ");
            int quantity = Validator.inputInt();
            System.out.println("Nhập giá: ");
            int price = Validator.inputInt();
            System.out.println("Nhập loại: ");
            String type = Validator.inputString();
            productsManager.update(idEdit, new Product(id, name, quantity, price, type));
            System.out.println("Bạn đã ửa thành công sản phẩm có id " + idEdit);
        }
    }

    public void searchProductById() {
        System.out.println("Bạn hãy nhập id của sản phẩm cần tìm :");
        int idSearch = Validator.inputInt();
        if (productsManager.searchById(idSearch) != null) {
            System.out.println("Sản phẩm có id " + idSearch + " là:");
            System.out.println(productsManager.searchById(idSearch));
        } else {
            System.out.println("Không tìm thấy sản phẩm có id " + idSearch);
        }
    }

    public void searchProductByType() {
        System.out.println("Hãy nhập loại sản phẩm cần tìm :");
        String type = Validator.inputString();
        if (!productsManager.searchByType(type).isEmpty()) {
            System.out.println("Những sản phẩm loại " + type + " là:");
            for (Product product : productsManager.searchByType(type)) {
                System.out.println(product);
            }
        }
        System.out.println("Không tìm thấy loại sản phẩm :" + type + " !");

    }

    public void searchProductByName() {
        System.out.println("Hãy nhập tên của sản phẩm cần tìm:");
        String nameSearch = Validator.inputString();
        if (!productsManager.searchByName(nameSearch).isEmpty()) {
            System.out.println("Sản phẩm có tên " + nameSearch);
            for (Product product : productsManager.searchByName(nameSearch)) {
                System.out.println(product);
            }
        } else {
            System.out.println("Không tìm thấy sản phẩm có tên " + nameSearch);
        }
    }

    public void deleteProduct() {
        System.out.println("Nhập id của sản phẩm cần xóa: ");
        int idDelete = Validator.inputInt();
        if (!productsManager.delete(idDelete)) {
            System.out.println("Không tìm thấy sản phẩm có id " + idDelete);
        } else {
            productsManager.delete(idDelete);
            System.out.println("Bạn đã xóa thành công sản phẩm có id: " + idDelete);
        }
    }

    public void addProduct() {
        System.out.println("===Thêm Sản Phẩm Mới===");
        System.out.println("Nhập Id Của Sản Phẩm Mới:");
        int id = Validator.inputInt();
        System.out.println("Nhập Tên Của Sản Phẩm Mới:");
        String name = Validator.inputString();
        System.out.println("Nhập Số Lượng Của Sản Phẩm Mới:");
        int quantity = Validator.inputInt();
        System.out.println("Nhập Giá Của Sản Phẩm Mới:");
        int price = Validator.inputInt();
        System.out.println("Nhập Loại Của Sản Phẩm Mới:");
        String type = Validator.inputString();
        productsManager.add(new Product(id, name, quantity, price, type));
        System.out.println("Bạn đã thêm thành công sản phẩm " + name + " vào kho.");
    }

    public void showAllProduct() {
        System.out.println("Tất cả sản phẩm trong kho là:");
        for (Product product : productsManager.findAll()) {
            System.out.println(product);
        }
    }

}
