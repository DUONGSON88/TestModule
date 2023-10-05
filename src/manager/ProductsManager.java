package manager;

import model.Product;
import readWrite.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class ProductsManager implements iManager<Product> {
    private List<Product> productList;
    private ReadAndWriteFile readAndWriteFile;

    public ProductsManager() {
        readAndWriteFile=new ReadAndWriteFile();
        productList = readAndWriteFile.readListSong();
    }

    @Override
    public void add(Product product) {
        productList.add(product);
        readAndWriteFile.writeListSong(productList);
    }

    @Override
    public boolean update(int id, Product product) {
        int index = findIndexById(id);
        if (index == -1) {
            return false;
        }
        productList.set(index, product);
        readAndWriteFile.writeListSong(productList);
        return true;
    }

    @Override
    public boolean delete(int id) {
        int index = findIndexById(id);
        if (index == -1) {
            return false;
        } else {
            productList.remove(index);
            readAndWriteFile.writeListSong(productList);
        }
        return true;

    }

    @Override
    public List<Product> findAll() {
        readAndWriteFile.readListSong();
        return productList;
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> listSearchName = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getName().toLowerCase().contains(name.toLowerCase())) {
                listSearchName.add(productList.get(i));
            }
        }
        readAndWriteFile.readListSong();
        return listSearchName;
    }

    @Override
    public List<Product> searchByType(String type) {
        List<Product> listSearchType = new ArrayList<>();
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getTypeProduct().equals(type)) {
                listSearchType.add(productList.get(i));
            }
        }
        readAndWriteFile.readListSong();
        return listSearchType;
    }

    @Override
    public Product searchById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                readAndWriteFile.readListSong();
                return productList.get(i);
            }
        }
        return null;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

}
