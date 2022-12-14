package efrei.fr.repository;

import efrei.fr.domain.Name;
import java.util.ArrayList;
import java.util.List;

public class NameRepository implements INameRepository
{
    private static NameRepository repository = null;

    private List<Name> nameDB = null;

    private NameRepository()
    {
        nameDB = new ArrayList<Name>();
    }





    public static NameRepository getRepository()
    {
        if ( repository == null)
        {
            return  new NameRepository();
        }
        return repository;
    }

    @Override
    public Name create(Name name)
    {
        boolean sucess = nameDB.add(name);
        if (sucess)
        {
            return name;
        }
        else
        {
            return null;
        }
    }

    @Override
    public Name read(String s)
    {
        for (Name r: nameDB)
        {
            if (r.getLastName().equals(s))
            {
                return r ;
            }
        }
        return null;
    }

    @Override
    public Name update(Name name)
    {
        Name oldName = read(name.getLastName());
        if (name!=null)
        {
            nameDB.remove(oldName);
            nameDB.add(name);
            return name;
        }
        return null;
    }

    @Override
    public boolean delete(String s)
    {
        Name nameToDelete = read(s);
        if (nameToDelete == null)
        {
            return false;
        }
        nameDB.remove(nameToDelete);
        return true;
    }

    @Override
    public List<Name> getAll()
    {
        return nameDB;
    }
}
