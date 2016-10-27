package kiba.trashcan;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;

/**
 * @author p455w0rd
 *
 */
public class ContainerTrashCan extends Container {
	
	IItemHandler playerInventory;
	IItemHandler trashInventory;
	
	public ContainerTrashCan(IItemHandler playerInv, IItemHandler trashInv, EntityPlayer player) {
		playerInventory = playerInv;
		trashInventory = trashInv;
		
		for (int i = 0; i < 9; i++) {
			addSlotToContainer(new SlotItemHandler(this.playerInventory, i, i * 20 + (9 + i), 90 + (3 - 1) + (3 * 20 + 6)));
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new SlotItemHandler(this.playerInventory, j + i * 9 + 9, j * 20 + (9 + j), 149 + (3 - 1) + i - (6 - 3) * 20 + i * 20));
			}
		}
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++) {
				addSlotToContainer(new SlotItemHandler(this.trashInventory, j + i * 9, j * 20 + (9 + j), 19 + i + i * 20));
			}
		}
	}

	/* (non-Javadoc)
	 * @see net.minecraft.inventory.Container#canInteractWith(net.minecraft.entity.player.EntityPlayer)
	 */
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}

}
