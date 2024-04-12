import { Flex, Image } from "@chakra-ui/react"

export const Header = () => {
  return (
    <Flex justifyContent="center" bg="red.500">
      <Image src="/logo.png" alt="logo" height="100px" />
    </Flex>
  )
}