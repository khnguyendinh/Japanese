Table table1 = new Table();
		ScrollPane scr = new ScrollPane(table1);
		final VerticalGroup v = new VerticalGroup();
		Label[] abc = new Label[150];
		for(int k = 0;k<150;k++){
			final int op = k;
			abc[k] = new Label("aaaaaaaaaaaaaaa"+k, ResourceManager.shared().lblStyleArial14);
			v.addActor(abc[k]);
			abc[k].debug();
			final int u =k;
			final Label a1 = abc[k];
			abc[k].addListener(new ClickListener(){
				@Override
				public void clicked(InputEvent event, float x, float y) {
					super.clicked(event, x, y);
					System.out.println("k "+op);
					Label abc1 = new Label("aaaaaaaaaaaaaaa khoa", ResourceManager.shared().lblStyleArial14);
					v.addActorAfter(v.getChildren().get(u), abc1);
					
					
				}
			});
		}
		table1.add(v);
		this.addActor(scr);
		scr.setPosition(300, 100);
		scr.setHeight(100);