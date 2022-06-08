package bstorm.akimts.mvc.service;

import bstorm.akimts.mvc.exceptions.ElementNotFoundException;
import bstorm.akimts.mvc.models.form.ChambreInsertForm;

public interface ChambreService {

    long insert(ChambreInsertForm form);

}
