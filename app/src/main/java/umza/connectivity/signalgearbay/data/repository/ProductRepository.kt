package umza.connectivity.signalgearbay.data.repository

import umza.connectivity.signalgearbay.data.model.Product
import umza.connectivity.signalgearbay.data.model.ProductCategory
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class ProductRepository {
    private val products = listOf<Product>(
        Product(
            id = 1,
            title = "Wi-Fi 6 Router",
            description = "This dual-band router provides fast wireless coverage for homes and small offices. Wi-Fi 6 handles busy networks efficiently when many devices are connected. Four Gigabit Ethernet ports support stable wired links for computers, switches, and storage.",
            category = ProductCategory.ROUTERS,
            price = 89.99,
            imageUrl = "https://images.unsplash.com/photo-1745847768408-b7b83796cae6",
        ),
        Product(
            id = 2,
            title = "Mesh Wi-Fi Router",
            description = "This mesh router creates dependable Wi-Fi coverage across larger spaces. Additional compatible units can extend the network without changing its name. Automatic band steering keeps phones, laptops, and smart equipment on a suitable connection.",
            category = ProductCategory.ROUTERS,
            price = 149.99,
            imageUrl = "https://images.unsplash.com/photo-1750712263185-edde9f359e33",
        ),
        Product(
            id = 3,
            title = "Travel Router",
            description = "This compact router creates a private wireless network from an Ethernet connection. Its small case fits easily into a field kit or travel bag. USB power makes it practical for temporary offices, exhibitions, and remote work.",
            category = ProductCategory.ROUTERS,
            price = 54.99,
            imageUrl = "https://images.unsplash.com/photo-1606904825846-647eb07f5be2",
        ),
        Product(
            id = 4,
            title = "Cable Modem",
            description = "This cable modem connects a compatible broadband line to a router or computer. A Gigabit Ethernet port provides a fast handoff to the local network. Status lights make connection and service checks quick during installation.",
            category = ProductCategory.MODEMS,
            price = 79.99,
            imageUrl = "https://images.unsplash.com/photo-1554098415-4052459dc340",
        ),
        Product(
            id = 5,
            title = "4G LTE Modem",
            description = "This cellular modem supplies internet access through a standard 4G SIM card. It is useful as a primary link at temporary sites or as backup connectivity. External antenna ports help improve reception in difficult indoor locations.",
            category = ProductCategory.MODEMS,
            price = 99.99,
            imageUrl = "https://images.unsplash.com/photo-1554098415-cae1af5e4f1a",
        ),
        Product(
            id = 6,
            title = "USB Cellular Modem",
            description = "This portable modem adds mobile data access to a compatible laptop or router. The USB connection supplies power and keeps setup simple. Its compact body suits mobile teams, service vehicles, and short-term installations.",
            category = ProductCategory.MODEMS,
            price = 49.99,
            imageUrl = "https://images.unsplash.com/photo-1691435828932-911a7801adfb",
        ),
        Product(
            id = 7,
            title = "8-Port Gigabit Switch",
            description = "This unmanaged switch adds eight Gigabit Ethernet connections to a local network. Plug-and-play operation requires no software configuration. The compact metal enclosure fits neatly on a desk, shelf, or small equipment cabinet.",
            category = ProductCategory.NETWORK_SWITCHES,
            price = 34.99,
            imageUrl = "https://images.pexels.com/photos/159304/network-cable-ethernet-computer-159304.jpeg",
        ),
        Product(
            id = 8,
            title = "16-Port Gigabit Switch",
            description = "This rack-mountable switch connects up to sixteen wired network devices. Gigabit ports deliver consistent performance for office computers, access points, and printers. Its fanless design keeps shared workspaces quiet while simplifying network expansion.",
            category = ProductCategory.NETWORK_SWITCHES,
            price = 74.99,
            imageUrl = "https://images.pexels.com/photos/2881233/pexels-photo-2881233.jpeg",
        ),
        Product(
            id = 9,
            title = "24-Port PoE Switch",
            description = "This managed switch carries network data and power to compatible devices over Ethernet. Twenty-four ports support access points, IP cameras, and desk phones from one cabinet. VLAN and traffic controls help administrators organise a growing business network.",
            category = ProductCategory.NETWORK_SWITCHES,
            price = 219.99,
            imageUrl = "https://images.pexels.com/photos/6466143/pexels-photo-6466143.jpeg",
        ),
        Product(
            id = 10,
            title = "Handheld Two-Way Radio",
            description = "This handheld radio provides clear push-to-talk communication for everyday teams. Selectable channels help separate departments and work groups. A rechargeable battery and belt clip make it convenient for retail, hospitality, and site operations.",
            category = ProductCategory.TWO_WAY_RADIOS,
            price = 39.99,
            imageUrl = "https://images.pexels.com/photos/14194761/pexels-photo-14194761.jpeg",
        ),
        Product(
            id = 11,
            title = "Waterproof Two-Way Radio",
            description = "This rugged radio is sealed against rain, splashes, and dusty working conditions. Its loud speaker supports clear calls in busy outdoor environments. Rechargeable power and an emergency alert function suit security, events, and maintenance crews.",
            category = ProductCategory.TWO_WAY_RADIOS,
            price = 69.99,
            imageUrl = "https://images.pexels.com/photos/15440100/pexels-photo-15440100.jpeg",
        ),
        Product(
            id = 12,
            title = "Long-Range Two-Way Radio",
            description = "This high-power handheld radio is designed for communication across large sites. Multiple channels and privacy codes reduce interruptions from nearby users. The supplied charging dock keeps the battery ready for warehouses, campuses, and field teams.",
            category = ProductCategory.TWO_WAY_RADIOS,
            price = 89.99,
            imageUrl = "https://images.pexels.com/photos/30516935/pexels-photo-30516935.jpeg",
        ),
    )

    fun observeById(id: Int): Flow<Product?> {
        val item = products.find { it.id == id }
        return flowOf(item)
    }

    fun getById(id: Int): Product? {
        return products.find { it.id == id }
    }

    fun observeAll(): Flow<List<Product>> {
        return flowOf(products)
    }
}
