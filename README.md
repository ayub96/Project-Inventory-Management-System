Coverage: 68.8%
# IMS Project

The following project implements an Inventory Management System which utilises MySQL and Java. A user may create/read/update/delete (CRUD) customers/items/orders in the system. In addition, a user may
calculate the cost of an order. A functionality has been added such that a user cannot add a quantity of items to an order if it exceeds the item's stock.

## Getting Started


These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.
	1. Download the latest version of Java
	2. Ensure you have access to a command line interface

### Prerequisites

What things you need to install the software and how to install them

```
jdk-14.0.1
```

### Installing

A step by step series of examples that tell you how to get a development env running

Download the ims-jar-with-dependencies.jar from the target folder

```
myIMS/target/ims-jar-with-dependencies.jar
```

Open a command line interface eg Git Bash and navigate to the folder containing the .jar file. Then type in the following command to run the .jar file:

```
java- jar- ims-jar-with-dependencies.jar
```

## Running the tests

Fork the repository to your PC. The JUnit tests may then be run using an IDE such as Eclipse.

### Unit Tests 

Unit tests are used to check that the Data Access Objects (DAOs) function correctly. This is done via the assertEquals() method which checks
whether the DAO has returned what we expect.

```
	@Test
	public void testReadAll() {
		List<Item> expected = new ArrayList<>();
		expected.add(new Item(1L,"GTA", 50L, 29.99));
		expected.add(new Item(2L,"PUBG", 60L, 39.99));
		assertEquals(expected, DAO.readAll());
	}
```

### Integration Tests 
Integration tests are used to confirm that objects function correctly

```
	@Test
	public void testCreate() {
		final String F_NAME = "barry", L_NAME = "scott";
		final Customer created = new Customer(F_NAME, L_NAME);

		Mockito.when(utils.getString()).thenReturn(F_NAME, L_NAME);
		Mockito.when(dao.create(created)).thenReturn(created);

		assertEquals(created, controller.create());

		Mockito.verify(utils, Mockito.times(2)).getString();
		Mockito.verify(dao, Mockito.times(1)).create(created);
	}
```

## Built With

* [Maven](https://maven.apache.org/) - Dependency Management

## Versioning

We use [SemVer](http://semver.org/) for versioning.

## Authors

* **Chris Perrins** - *Initial work* - [christophperrins](https://github.com/christophperrins)
* **Ayub Azhar-Yusuf** - *Completion of project* - [Ayub96](https://github.com/ayub96)

## License

This project is licensed under the MIT license - see the [LICENSE.md](LICENSE.md) file for details 

*For help in [Choosing a license](https://choosealicense.com/)*
