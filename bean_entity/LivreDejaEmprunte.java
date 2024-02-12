
package bean_entity;

import jakarta.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class LivreDejaEmprunte extends Exception {}


