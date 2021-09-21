package com.olplatform.olplatform.models;

import com.olplatform.olplatform.interfaces.Manageable;
import com.olplatform.olplatform.interfaces.Terminable;
import java.util.Date;

public abstract class Administrable implements Manageable, Terminable {
  protected long id = 0L;

  protected String name;

  protected String description;

  protected Date startDate;

  protected Date endDate;
}
